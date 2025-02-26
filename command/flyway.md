Here’s a comprehensive list of **Flyway commands** categorized for clarity. Flyway is a database migration tool that focuses on simplicity and convention over configuration.

---

### 🔍 **Info & Validation Commands**
- `flyway info` – Displays the status of all migrations, showing which have been applied and which are pending.
- `flyway validate` – Validates applied migrations against the available ones to detect errors.
- `flyway history` – Shows detailed migration history, including execution time and success status.
- `flyway info -outputType=json` – Shows migration info in JSON format (useful for automation).

---

### ⚡ **Migration Commands**
- `flyway migrate` – Applies all pending migrations to the database.
- `flyway undo` – Reverts the most recently applied migration (only works with undo scripts).
- `flyway repair` – Repairs the schema history table (e.g., fixes checksums, removes failed migrations).

---

### 🔙 **Rollback & Baseline Commands**
- `flyway baseline` – Sets a baseline version for an existing database (useful for integrating Flyway into legacy databases).
- `flyway clean` – Drops all objects in the configured schemas (be cautious, this **deletes all data**).

---

### 🏷️ **Target & Version Control**
- `flyway target=<version>` – Migrates the database up to a specific version.
- `flyway outOfOrder=true` – Allows migrations to run even if they were applied out of order.

---

### ⚙️ **Configuration & Misc Commands**
- `flyway repair` – Fixes any issues in the schema history table (e.g., updates checksums).
- `flyway schemaHistory` – Shows the schema history table directly.
- `flyway validateMigrationNaming` – Validates that migration scripts follow naming conventions.

---

### 🆘 **Help & Version Info**
- `flyway -v` or `flyway --version` – Displays the installed Flyway version.
- `flyway -h` or `flyway --help` – Provides help and usage information.

---

Would you like to dive deeper into any specific command or see an example of how to configure Flyway? 🚀