# Makefile for Kotlin project with Gradle

# Define the default task
.DEFAULT_GOAL := help

# Define the Gradle wrapper script
GRADLEW = ./gradlew

# Gradle tasks
build: ## Build the project
	$(GRADLEW) clean build

run: ## Run the application
	$(GRADLEW) run

test: ## Run tests
	$(GRADLEW) test

migrate: ## Run Flyway database migrations
	$(GRADLEW) flywayMigrate

clean: ## Clean the project
	$(GRADLEW) clean

up: ## Up infrastructure
	docker-compose up -d

down: ## Down infrastructure
	docker-compose down

help: ## Show this help message
	@echo "Usage: make [target]"
	@echo "Targets:"
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "    %-20s %s\n", $$1, $$2}' $(MAKEFILE_LIST)

.PHONY: build run test flywayMigrate clean help