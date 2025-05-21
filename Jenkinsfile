pipeline {
  agent any

  parameters {
    string(name: 'BUILD_ID', defaultValue: 'latest', description: 'Versión de imagen a generar')
  }

  environment {
    IMAGE_NAME = "fleet_master_main_project"
  }

  stages {
    stage('Compilar proyecto con Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Limpiar contenedor anterior') {
      steps {
        sh """
          docker stop "fleet_master_main" || true

          docker rm "fleet_master_main_project" || true
        """
      }
    }

    stage('Construir imagen Docker') {
      steps {
        sh 'docker build -t ${IMAGE_NAME}:${BUILD_ID} .'
      }
    }

  }

  post {
    success {
      echo "Build e imagen ${IMAGE_NAME}:${BUILD_ID} creada correctamente."
    }
    failure {
      echo "Fallo en el build."
    }
  }
}
