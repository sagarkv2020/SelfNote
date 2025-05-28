import requests
from bs4 import BeautifulSoup
import re

def scrape_and_process(url):
    # Fetch the webpage
    response = requests.get(url)
    if response.status_code != 200:
        print(f"Failed to fetch URL: {url}")
        return None
    
    # Parse the HTML
    soup = BeautifulSoup(response.content, 'html.parser')
    
    # Dictionary to store the results
    result = {}
    
    # Find all blockquotes
    for index, blockquote in enumerate(soup.find_all('blockquote', class_='postcontent restore')):
    #for blockquote in soup.find_all("div", {"class": "postbody"}):

        print("test")
        # Try to find a title
        #title_tag = blockquote.find_next(['h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'strong', 'span'])
        #title = title_tag.get_text(strip=True) if title_tag else "Untitled Block"${index}
        title = f"Untitled Block-${index}"
        
        # Convert blockquote to string and pre-process it
        blockquote_str = str(blockquote)
        
        # Split the blockquote content at each <a href occurrence
        processed_lines = []
        for line in blockquote_str.split('\n'):
            # First to change the List# of the competed Id
            # Split line at each <a href while preserving the delimiter
            split_lines = re.split('(<a href[^>]*>)', line)
            # Reconstruct lines with proper separation
            reconstructed = []
            for i, part in enumerate(split_lines):
                if part.startswith('<a href'):
                    if reconstructed and not reconstructed[-1].endswith('\n'):
                        reconstructed[-1] += '\n'
                    reconstructed.append(part)
                else:
                    if reconstructed:
                        reconstructed[-1] += part
                    else:
                        reconstructed.append(part)
            processed_lines.extend(reconstructed)
        
        # Process each <a href section
        image_urls = []
        for line in processed_lines:
            if line.strip().startswith('<a href'):
                # Find all img src in this line (there might be multiple)
                img_src_matches = re.findall(r'<img[^>]*src=[\'"]([^\'"]*)[\'"]', line)
                for img_url in img_src_matches:
                    # Transform the URL
                    transformed = img_url.replace('imx', 'i002.imx').replace('u/t', 'i')
                    image_urls.append(f"'{transformed}',")
        
        # Add to result if we found any URLs
        if image_urls:
            result[title] = [url.strip() for url in image_urls]
    
    # Format the output
    output = []
    for title, urls in result.items():
        output.append(f'"{title}": [')
        output.extend(f'    {url}' for url in urls)
        output.append('],')
    
    return '\n'.join(output)

# Example usage:
url = "https://url/page9"  # Replace with your target URL
output_data = scrape_and_process(url)

# Write output to a text file
with open('blockquote_images.txt', 'w', encoding='utf-8') as f:
    f.write(output_data)

print("Results have been saved to blockquote_images.txt")
