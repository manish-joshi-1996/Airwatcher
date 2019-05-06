cd accountmanager
source ./env-variable.sh
mvn clean package
cd ..
cd airwatcher
source ./env-variable.sh
mvn clean package
cd ..
