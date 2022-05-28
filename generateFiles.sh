# Grab our parameters
context="/Users/johnstocktoniv/Documents/Code/Algorithms"
directoryName="$1"
fileExtension=$2
algorithms="../Algorithms.txt"

# Main 
# Make Directory
cd "$context"
mkdir "$directoryName";
cd "$directoryName"
echo "Created: $directoryName"

# Generate Files
while read -r line
do
  fileName="./$line.$fileExtension"
  touch $fileName
  echo "\t> Generated File: $fileName"
done < "$algorithms"