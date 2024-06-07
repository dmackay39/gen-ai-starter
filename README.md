# How to run with Docker
- Create a file called env.properties in the backend folder and give it a property API_KEY=<Your OpenAI API key>.
- In application.properties, set spring.datasource.url=jdbc:postgresql://postgres:5432/vector_store
- Download Docker Desktop.
- Open Docker desktop so the Docker engine is running.
- In terminal, cd to root folder and run docker compose up.
- Open the app on localhost:3000.

# Things to add
- Function calling example.
- Sentiment analysis example.
