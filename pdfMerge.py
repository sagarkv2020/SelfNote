from PyPDF2 import PdfMerger

merger = PdfMerger()
pdfs = [
    "Accenture_11833391_Relieving Letter(Automatic).pdf",
    "Experience_Letter_Infosys_783497.pdf",
    "Experience_Letter_Cognizant_303617.pdf"
    ]

for pdf in pdfs:
    merger.append(pdf)

merger.write("merged_output.pdf")
merger.close()
