# GitHub Repository Setup Instructions

## Creating the Public GitHub Repository

Since we can't push directly from this environment, follow these steps to create the public GitHub repository:

### Step 1: Create Repository on GitHub.com

1. Go to https://github.com
2. Sign in to your account
3. Click the "+" icon → "New repository"
4. Repository settings:
   - **Name**: `bajaj-finserv-health-qualifier`
   - **Description**: `Spring Boot application for Bajaj Finserv Health Qualifier Challenge`
   - **Visibility**: ✅ Public
   - **Initialize**: ❌ Don't add README, .gitignore, or license (we have them)

### Step 2: Upload Your Local Code

Option A - Command Line (if Git is configured):
```bash
# Add remote origin
git remote add origin https://github.com/YOUR_USERNAME/bajaj-finserv-health-qualifier.git

# Push to GitHub
git branch -M main
git push -u origin main
```

Option B - GitHub Web Interface:
1. After creating the repository, click "uploading an existing file"
2. Drag and drop all files from your `bajaj-finserv-qualifier` folder
3. Commit message: "Initial commit: Bajaj Finserv Health Qualifier"
4. Click "Commit changes"

### Step 3: Automatic JAR Build

Once pushed, GitHub Actions will automatically:
1. Build the Spring Boot application
2. Create a JAR file
3. Create a release with downloadable JAR

### Expected Repository URLs

After setup, your URLs will be:

**Repository URL**: 
```
https://github.com/YOUR_USERNAME/bajaj-finserv-health-qualifier
```

**JAR Download URL** (after build completes):
```
https://github.com/YOUR_USERNAME/bajaj-finserv-health-qualifier/releases/download/v1.0.0/bajaj-finserv-qualifier.jar
```

### Files to Upload

Ensure these files are in your repository:
- ✅ `src/` directory with all Java code
- ✅ `pom.xml` (Maven configuration)
- ✅ `README.md` (Documentation)
- ✅ `.github/workflows/build.yml` (Auto-build configuration)
- ✅ `.gitignore` (Git ignore rules)
- ✅ All documentation files

### Verification

After upload, verify:
1. All source code is visible in the repository
2. GitHub Actions tab shows a successful build
3. Releases section has the JAR file available for download
4. Repository is set to Public visibility

## Alternative: Direct Upload Method

If you prefer to create the JAR locally:

1. Install Maven from https://maven.apache.org/download.cgi
2. Run: `mvn clean package`
3. Upload the generated `target/bajaj-finserv-qualifier.jar` to GitHub Releases manually

## For Submission Form

Use these URLs in your submission:

**GitHub Repository**: `https://github.com/YOUR_USERNAME/bajaj-finserv-health-qualifier`

**JAR Download Link**: `https://github.com/YOUR_USERNAME/bajaj-finserv-health-qualifier/releases/download/v1.0.0/bajaj-finserv-qualifier.jar`

Replace `YOUR_USERNAME` with your actual GitHub username.
