pipeline {
    agent any
    environment {
        PATH="/Users/zhangwx8/miniconda3/bin:$PATH"
        conda_env='jenkin-conda-env'
    }
    stages {
        stage('Verify') {
            steps {
                sh 'echo "$PATH"'
                sh 'conda --version'
                sh '''
                  python --version
                '''
                sh 'printenv'
                sh 'ls -l "$WORKSPACE"'
            }
        }
        stage('Unit Test') {
            steps {
                sh '''
                    source /Users/zhangwx8/miniconda3/etc/profile.d/conda.sh
                    conda activate $conda_env
                    python3 -m pytest tests/
                '''
            }
        }
        stage('ETL') {
            steps {
                sh '''
                    docker-compose -f docker-compose-etl.yml up
                '''
            }
        }
        stage('Train') {
            steps {
                sh '''
                    docker-compose -f docker-compose-train.yml up
                '''
            }
        }
        stage('predict') {
            steps {
                sh '''
                    docker-compose -f docker-compose-predict.yml up
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                    docker-compose -f docker-compose-fastapi.yml down --remove-orphans
                    docker-compose -f docker-compose-fastapi.yml up -d
                '''
            }
        }

    }
}