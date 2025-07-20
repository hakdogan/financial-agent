# financial-agent

`financial-agent` is an AI-powered financial assistant built with [Quarkus's](https://quarkus.io/), [Ollama](https://ollama.com/) and [LangChain4j](https://github.com/langchain4j/langchain4j) extensions.  
It leverages **function calling** to query real-time stock, currency, and precious metal prices from external APIs.

## ✨ Features

- 💱 **Exchange Rates**: Fetches real-time stock and currency exchange rates using the [Alpha Vantage API](https://www.alphavantage.co/).
- 🪙 **Precious Metals Prices**: Retrieves current metal prices (gold, silver, etc.) using the [GoldAPI](https://www.goldapi.io/).
- 🧠 **LLM-powered reasoning**: Uses [Ollama](https://ollama.com/) and [LangChain](https://www.langchain.com/) for intelligent prompt interpretation and function calling.
- 🐳 **Automatic Ollama Integration**: If Docker or Podman is available, the Ollama instance is automatically launched by Quarkus during dev mode.

## 🚀 Getting Started

### Prerequisites

- JDK 17+
- Maven 3.8+
- Docker or Podman (for automatic Ollama instance startup)
- Alpha Vantage and GoldAPI API keys

### Run in development mode
You can start the application with your API keys as system properties:
```bash
mvn -DEXCHANGE_API_KEY=your_alpha_vantage_key -DMETAL_API_KEY=your_goldapi_key quarkus:dev
```

> ℹ️ During startup, if Docker or Podman is available, Quarkus will automatically launch an Ollama container.

### 🐳 Run with Docker Compose
You can also run the application and Ollama together using Docker Compose.

1. Set your API keys
   Create a `.env` file in the project root:

```bash
EXCHANGE_API_KEY=your_alpha_vantage_key
METAL_API_KEY=your_goldapi_key
```

2. Build the JAR
```bash
mvn clean package -DskipTests
```
3. Start with Docker Compose
```bash
docker-compose up --build
```
This will:

- Start an Ollama container and automatically download the llama3:2 model.
- Start your Quarkus-based financial agent service.
- Connect both services in the same Docker network.

## 🛠️ Configuration
| Property	      | Description                | 	Example                    |
|----------------|----------------------------|-----------------------------|
| EXCHANGE_API_KEY	 | API key for Alpha Vantage  | 	ABC123XYZ                  |
| METAL_API_KEY	 | API key for GoldAPI | 	goldapi-xxxxxxxx-xxxx-xxxx |
| OLLAMA_BASE_URL |	Base URL for Ollama service (optional) | http://ollama:11434 |

### Example Prompts

```bash
http GET "http://localhost:8080/api/v1/exchange/1 dolar kaç Türk lirası?"

1 dolar 40.24630000 Türk lirasıdır. Güncellenme tarihi: 2025-07-16 13:54:11.

http GET "http://localhost:8080/api/v1/exchange/Altının ons fiyatı ne kadar?"

Altının (XAU) ons fiyatı şu anda 3323.72 USD'dir.

http GET "http://localhost:8080/api/v1/exchange/Apple güncel fiyatı nedir?"

Apple'ın (AAPL) güncel fiyatı 211,18 USD'dir.
```