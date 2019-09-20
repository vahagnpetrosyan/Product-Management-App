CREATE TABLE IF NOT EXISTS "products" (
  "id"      SERIAL PRIMARY KEY,
  "name"    VARCHAR(64) NOT NULL,
  "code"    VARCHAR(64) NOT NULL UNIQUE ,
  "release_date" DATE NOT NULL DEFAULT CURRENT_DATE,
  "description" VARCHAR(255),
  "price" FLOAT(2) NOT NULL,
  "rating" FLOAT(2) NOT NULL,
  "image_url" VARCHAR(255),
  "created_at" TIMESTAMP DEFAULT now(),
  "updated_at" TIMESTAMP DEFAULT now()
);

CREATE TABLE IF NOT EXISTS "users" {
  "id" SERIAL PRIMARY KEY,
  "name" VARCHAR(64) NOT NULL UNIQUE
  "email" VARCHAR(255) UNIQUE
  "password" VARCHAR(255) NOT NULL


}