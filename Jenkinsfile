pipeline {
    agent any
    environment {
        PATH="/homes/zhangwx8/anaconda3/condabin:$PATH"
    }
    stages {
        stage('Verify') {
            steps {
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