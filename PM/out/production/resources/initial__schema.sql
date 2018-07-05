CREATE TABLE IF NOT EXISTS "products" (
  "id"      SERIAL PRIMARY KEY,
  "name"    VARCHAR(64) NOT NULL,
  "code"    VARCHAR(64) NOT NULL,
  "releaseDate" DATE NOT NULL DEFAULT CURRENT_DATE,
  "description" VARCHAR(255),
  "price" FLOAT(2) NOT NULL,
  "rating" FLOAT(2) NOT NULL,
  "imageUrl" VARCHAR(255),
  "created_at" TIMESTAMP DEFAULT now(),
	"updated_at" TIMESTAMP DEFAULT now()
);