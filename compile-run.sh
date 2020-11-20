curl -X GET localhost:8080/shutdown
sleep 5
PID=$(ps -eo pid,command | grep alamisharia-rest-api.jar| grep -v grep | awk '{print $1}')
if [ -z $PID ];
then
echo "alamisharia rest api is stopped"
else
echo "alamisharia rest api is still running, we will force to kill it"
for pid in $(ps -ef | grep "alamisharia-rest-api" | awk '{print $2}'); do kill -9 $pid; done
fi

mvn clean package -DskipTests

JAVA_OPTS="-Duser.timezone=Asia/Jakarta -jar"
JAR_FILE="target/alamisharia-rest-api.jar"
java $JAVA_OPTS $JAR_FILE &
exit 0


