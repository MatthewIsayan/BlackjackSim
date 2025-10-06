# DevTools PowerShell module for project-wide developer utilities
# Import using: Import-Module ./scripts/dev/devTools.psm1

function Open-JaCoCo {
    $reportPath = Join-Path $PWD "target/site/jacoco/index.html"
    if (Test-Path $reportPath) {
        Write-Host "Opening JaCoCo report..." -ForegroundColor Green
        Start-Process $reportPath
    } else {
        Write-Host "Report not found. Try running 'mvn clean verify' first." -ForegroundColor Yellow
    }
}

function Invoke-Tests {
    Write-Host "Running tests..." -ForegroundColor Cyan
    mvn clean verify
}

# Add convenient short aliases
Set-Alias openCoverage Open-JaCoCo
Set-Alias test Invoke-Tests

Write-Host "DevTools module loaded. Commands: openCoverage, test" -ForegroundColor Cyan
