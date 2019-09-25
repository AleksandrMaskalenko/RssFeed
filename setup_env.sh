docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=nimda -e MYSQL_DATABASE=feeds -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:latest

docker image build -t rssfeed .
docker run --rm -p 8080:8080 --name rssfeed --link mysql-standalone:mysql -d rssfeed

docker exec -i mysql-standalone mysql -uroot -pnimda < feeds.sql
docker exec -i mysql-standalone mysql -u root --password=nimda -e 'alter table feeds.items change link link varchar(1000);'
