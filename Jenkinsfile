pipeline {
  agent any

  environment {
    IMAGE_NAME = "fleet_master_main_project"
    SERVICE_NAME = "fleet_master_main"
    GH_TOKEN = credentials("github-token")
    BUILD_ID = "${env.BUILD_ID}"
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

    stage ('Delivery'){
        steps{
            sh '''
            rm -rf fleet-master-deployment
            git clone https://github.com/diegoalamilla/fleet-master-deployment
            cd fleet-master-deployment
            sed -i "s/^FLEET_MAIN_BUILD_ID=.*/FLEET_MAIN_BUILD_ID=${BUILD_ID}/" .env
            git config user.name "Jenkins[bot]"
            git config user.email "jenkins[bot]@fleetmaster.com"
            git add .env
            git commit -m "chore: update ${IMAGE_NAME} image to ${BUILD_ID}"
            git push https://x-access-token:${GH_TOKEN}@github.com/diegoalamilla/fleet-master-deployment.git

            '''
        }
    
  }

  }

  

  post {
    success {
      echo "Build e imagen ${IMAGE_NAME}:${BUILD_ID} creada correctamente."
      echo "Devlivery hecho correctamente"
    }
    failure {
      echo "Fallo en el build."
    }
  }
}
