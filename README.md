
# Start Spring

```sh
mvn spring-boot:run
```

#Start postgres db as container
```sh
docker run --name BloodDonor-Database --rm \
-e POSTGRES_PASSWORD=pass123 \
-e POSTGRES_USER=dbuser \
-e POSTGRES_DB=BloodDonors \
-d --net=host \
-v ds-lab-vol:/var/lib/postgresql/data \
postgres:14
```
