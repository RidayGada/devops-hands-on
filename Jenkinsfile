pipeline {

    agent any

    tools {
        jdk 'JDK-25'
        maven 'Maven-3.9'
    }

    environment {
        DB_USERNAME = credentials('db-username')
        DB_PASSWORD = credentials('db-password')
    }

    stages {

        stage('Checkout Source Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/RidayGada/devops-hands-on.git'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Stop Existing Application') {
    steps {
        bat '''
        @echo off

        set PID=

        for /f "tokens=5" %%a in ('netstat -ano ^| findstr :9999') do (
            set PID=%%a
        )

        if defined PID (
            echo Stopping application running on port 9999...
            taskkill /F /PID %PID%
        ) else (
            echo No application is running on port 9999.
        )

        exit /b 0
        '''
    }
}


stage('Deploy') {
    steps {
        bat '''
        taskkill /F /IM java.exe >nul 2>&1

        start "" java ^
        -DDB_USERNAME=%DB_USERNAME% ^
        -DDB_PASSWORD=%DB_PASSWORD% ^
        -jar target\\student-management-0.0.1-SNAPSHOT.jar
        '''
    }
}

    }

    post {

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }

    }

}