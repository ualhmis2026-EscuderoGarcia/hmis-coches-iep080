pipeline {
    agent any

    tools {
        maven "maven default"
    }

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-21-openjdk-amd64"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Git fetch') {
            steps {
                git branch: 'main', url: 'https://github.com/ualhmis2026-EscuderoGarcia/hmis-coches-iep080.git'
            }
        }

        stage('Check tools') {
            steps {
                sh "java -version"
                sh "mvn -version"
            }
        }

        stage('Compile, Test, Package') {
            steps {
                sh "mvn clean package -Ddependency-check.skip=true"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'

                    archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true

                    jacoco(
                        execPattern: '**/target/jacoco.exec',
                        classPattern: '**/target/classes',
                        sourcePattern: '**/src/',
                        exclusionPattern: '**/test/'
                    )

                    publishCoverage adapters: [
                        jacocoAdapter('**/target/site/jacoco/jacoco.xml')
                    ]
                }
            }
        }

        stage('Analysis') {
            steps {
                sh "mvn site"
            }

            post {
                always {
                    dependencyCheckPublisher pattern: '**/target/site/dependency-check-report.xml'

                    recordIssues enabledForFailure: true, tool: checkStyle()
                    recordIssues enabledForFailure: true, tool: pmdParser()
                    recordIssues enabledForFailure: true, tool: cpd()
                    recordIssues enabledForFailure: true, tool: spotBugs()
                }
            }
        }

        stage('Documentation') {
            steps {
                sh "mvn site javadoc:javadoc javadoc:aggregate -Ddependency-check.skip=true"
            }

            post {
                always {
                    step $class: 'JavadocArchiver',
                        javadocDir: 'target/site/apidocs',
                        keepAll: true

                    publishHTML(target: [
                        reportName: 'Maven Site',
                        reportDir: 'target/site',
                        reportFiles: 'index.html',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false
                    ])
                }
            }
        }
    }
}