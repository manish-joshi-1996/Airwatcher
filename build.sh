cd accountmanager
source ./env-variable.sh
mvn clean package
docker build -t user-app
cd ..
cd airwatcher
source ./env-variable.sh
mvn clean package
docker build -t airwatch-app
cd ..
