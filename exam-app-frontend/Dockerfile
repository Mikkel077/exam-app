# Stage 1: build the Vite React app
FROM node:18-alpine AS builder

# Set working directory
WORKDIR /app

# Copy package manifests and install dependencies
COPY package.json package-lock.json ./
RUN npm ci

# Copy rest of the source and build
COPY . .
RUN npm run build

# Stage 2: serve with Nginx
FROM nginx:alpine

# Remove default static assets
RUN rm -rf /usr/share/nginx/html/*

# Copy build output
COPY --from=builder /app/dist /usr/share/nginx/html

# Expose HTTP port
EXPOSE 80

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
