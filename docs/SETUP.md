# Setup Tips
## ☕ Verify Java 25 Environment

Before using the DevTools module, make sure your system is configured to use **Java 25**.

### Step 1 — Check your Java version

```powershell
mvn -v
````

You should see output similar to:

```
Java version: 25, vendor: Amazon.com Inc., runtime: C:\Users\User\.jdks\corretto-25
```

If it shows an older version, install **JDK 25** and update your environment variables.

### Step 2 — Verify `JAVA_HOME` and `PATH`

Check your current Java environment:

```powershell
echo $env:JAVA_HOME
```

Expected result:

```
C:\Users\User\.jdks\corretto-25
```

Also verify that your JDK’s `bin` directory is in the PATH:

```powershell
echo $env:PATH
```

If not, update your environment variables:

1. Open **System Properties → Advanced → Environment Variables**
2. Under **System variables**, set:

    * `JAVA_HOME` → `C:\Program Files\Java\jdk-25`
3. Edit the `Path` variable and add:

   ```
   %JAVA_HOME%\bin
   ```

> ✅ Both `JAVA_HOME` and `PATH` must point to **Java 25** for Maven, IntelliJ, and DevTools commands to work correctly.


# 🧰 DevTools PowerShell Module Setup

This project includes a lightweight **PowerShell developer utility module** that provides simple commands for running Maven tests and viewing JaCoCo coverage reports.  
It standardizes the developer workflow across the team.

---

## ⚙️ Commands Overview

| Command        | Description                                                     |
|----------------|-----------------------------------------------------------------|
| `test`         | Runs `mvn clean verify` and prints test results                 |
| `openCoverage` | Opens the JaCoCo HTML report at `target/site/jacoco/index.html` |

---

## 🧠 Helpful PowerShell Profile Setup

To ensure the DevTools module loads **automatically for every developer**, each team member must configure their PowerShell profile.  
This ensures consistent tooling across all environments, including IntelliJ’s terminal.

### Step 1 — Check if you already have a PowerShell profile in the Project Root Directory

```powershell
Test-Path $PROFILE
````

If it returns `False`, create one:

```powershell
New-Item -Type File -Path $PROFILE -Force
```

### Step 2 — Open your profile for editing

```powershell
notepad $PROFILE
```

### Step 3 — Add this line to the end of your profile

```powershell
Import-Module "$PWD/scripts/dev/devTools.psm1" -Force
```

> 💡 This automatically loads the module every time a new PowerShell session starts, including IntelliJ’s integrated terminal.

### Step 4 — Restart PowerShell or IntelliJ

After restarting, you should see:

```
DevTools module loaded. Commands: openCoverage, test
```

You can now use the commands directly in any new terminal session.

---

## 🧪 Usage

| Command                        | Description                       |
|--------------------------------|-----------------------------------|
| `test`                         | Runs `mvn clean verify`           |
| `openCoverage`                 | Opens the JaCoCo HTML report      |


## ✨ Example Session

```
PS C:\Projects\BlackjackSim> test
Running tests...
[INFO] -------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] -------------------------------------------------------

PS C:\Projects\BlackjackSim> openCoverage
Opening JaCoCo report...
```
