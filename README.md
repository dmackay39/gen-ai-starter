# Intro
When I learn new technologies, I like to make simple projects for future reference! This is one of those projects. The skills I tried to practice here were SpringAI, Docker, React.

In this project:
- RAG with embedding and vector stores.
- Function calling using an external API for maths (Newton).
- Docker for containerisation and pulling a PostGres database image.
- Frontend with React Bootstrap.
- Backend with Spring.

# Requirements
- [Docker desktop](https://www.docker.com/products/docker-desktop/)
- OpenAI API key

# How to run with Docker
- Create a file called env.properties in the backend folder and give it a property API_KEY= Your OpenAI API key.
- Open Docker desktop so the Docker engine is running.
- In terminal, cd to root folder and run docker compose up.
- Open the app on localhost:3000.

# Things to add
- Sentiment analysis example.
