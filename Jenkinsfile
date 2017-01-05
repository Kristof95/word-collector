node{
	stage('Checkout'){
		checkout scm
	}
	
	stage('Build'){
		withEnv(["PATH+MAVEN=${tool 'M3'}"]){
			sh 'mvn clean install'
		}
	}
	
	stage('Deploy to Cloud Foundry'){
		sh '''
			password=`cat pw`
			cf login -a "https://api.run.pivotal.io/" -o "devops-app-test" -s "development" -u "matrixsprt@gmail.com" -p "$password"
			cf push word-gather -m 512M -p target/backend-template-0.0.1-SNAPSHOT.jar
			cf start word-gather
		   '''
	}
	
	stage('Application Status'){
		sh 'cf apps'
	}
}