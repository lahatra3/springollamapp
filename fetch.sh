curl --request POST \
  --url http://localhost:3131/generate \
  --header 'Content-Type: application/json' \
  --data '{
	"message": "hello"
}'