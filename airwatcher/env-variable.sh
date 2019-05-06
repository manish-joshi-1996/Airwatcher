export MYSQL_DATABASE=citydb
export MYSQL_USER=root
export MYSQL_PASSWORD=root
if [[ -z "${MYSQL_CI_URL}" ]]; then
export MYSQL_CI_URL=jdbc:mysql://localhost/citydb
fi

