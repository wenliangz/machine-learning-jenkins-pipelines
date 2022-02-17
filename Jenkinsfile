pipeline {
    agent any
    environment {
        PATH="/Users/zhangwx8/miniconda3/bin:$PATH"
        conda_env='jenkins-conda-env'
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
                activate_conda()
                sh '''
                    python3 -m pytest tests/
                '''
            }
        }
        stage('ETL') {
            steps {
                activate_conda()
                sh '''
                    docker-compose -f docker-compose-etl.yml up
                '''
            }
        }
        stage('Train') {
            steps {
                activate_conda()
                sh '''
                    docker-compose -f docker-compose-train.yml up
                '''
            }
        }
        stage('predict') {
            steps {
                activate_conda()
                sh '''
                    docker-compose -f docker-compose-predict.yml up
                '''
            }
        }
        stage('Deploy') {
            steps {
                activate_conda()
                sh '''
                    docker-compose -f docker-compose-fastapi.yml down --remove-orphans
                    docker-compose -f docker-compose-fastapi.yml up -d
                '''
            }
        }

    }
}

void activate_conda() {
    sh '''
    source /Users/zhangwx8/miniconda3/etc/profile.d/conda.sh
    conda activate $conda_env
    '''
}