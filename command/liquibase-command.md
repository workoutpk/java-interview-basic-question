Liquibase is a powerful database schema change management tool. Here’s a list of commonly used **Liquibase commands** categorized for clarity:

### 🔍 **Status & Validation Commands**
- `liquibase status` – Shows pending changesets that haven’t been applied yet.
- `liquibase validate` – Validates your changelog file for errors.
- `liquibase history` – Lists all changesets that have been applied to the database.
- `liquibase diff` – Compares two databases to identify differences.
- `liquibase diffChangeLog` – Generates a changelog based on differences between two databases.

---

### ⚡ **Update Commands**
- `liquibase update` – Applies all pending changesets to the database.
- `liquibase updateCount <number>` – Applies a specified number of pending changesets.
- `liquibase updateToTag <tag>` – Updates the database to a specific tag.

---

### 🔙 **Rollback Commands**
- `liquibase rollback <tag>` – Rolls back changes up to the specified tag.
- `liquibase rollbackCount <number>` – Rolls back the specified number of changesets.
- `liquibase rollbackToDate <date>` – Rolls back changes up to a specific date.

---

### 📜 **Changelog Generation Commands**
- `liquibase generateChangeLog` – Generates a changelog based on the current state of the database.
- `liquibase changelogSync` – Marks all changesets as executed without running them.
- `liquibase changelogSyncToTag <tag>` – Marks changesets up to the specified tag as executed.

---

### 🛠️ **Database Management Commands**
- `liquibase clearCheckSums` – Clears all saved checksums so they will be recalculated.
- `liquibase dropAll` – Drops all database objects managed by Liquibase.
- `liquibase snapshot` – Generates a snapshot of the current database state.

---

### 🏷️ **Tagging Commands**
- `liquibase tag <tag>` – Tags the current state of the database for future rollbacks.

---

### 📂 **Help & Documentation**
- `liquibase help` – Lists available commands or provides help for a specific command.
- `liquibase version` – Displays the installed Liquibase version.

---

Would you like help with examples for any specific command? 🚀