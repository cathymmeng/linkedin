# UI SEARCH FUNCTION ANALYSIS

## PURPOSE OF VERIFICATION from UI

```
1. Check Bunnings homepage is opening or not after entering https://www.bunnings.com.au in the URL box
2. Check the search function on the homepage, searching result should be correctly visible and relevant to search keyword
3. Results of search are displaying in sorted order (based on logic of popularity/most relevant etc.)
```

## STATEGY & APPROACH 

#### POSITIVE SCENARIOS
```
1. Check how many results display on a single page
2. Check the pre-set ranking & display
3. Searching the keyword with results that takes multi-pages to display
4. There should be pre-defined search criteria for auto complete e.g. after typing first 3 letters it should suggest matching keyword
5. When user clicks on any link from result and navigates back, then result should be maintained
6. After clicking Search field - search history should be displayed (latest search keyword)
7. Pagination should be tested for searches returning high number of records
8. Total number of search records/results should be displayed on page
9. Search keyword should get highlighted with color in the search results? Is this the case?
10. Water text should be provided for user to understand what to search
```

#### NEGATIVE SCENARIOS
```
1. special characters search - SEARCH should only take count in the alphanumeric values 
2. irrelevant keyword search - "Did you mean" link to provide recommendations based on the input, mapping logic?
```

## QUESTIONS & ASSUMPTIOMS

```
0. Fucntion verification - accptance criteria???
1. Whether there is concerns on performance (e.g. amount of time it taks for the page to load)?
2. Lower level verification based on implementation logic has been done and searching results are satisfactory?
3. Whether SEARCH function is case sensitive?
4. Are the searching results all displaying in the center of the screen? Will this consider the size of the devices used?
5. Minimum to maximum length setting for the text box
6. Search results should be cleared on clicking clear search button? Does this button exist?
```

## TEST CONDUCTION RECOMMENDATION

```
1. The test on SEARCH function logic implementation should be conducted from API / MS level instead of UI, to be more cost effective
2. SEARCH funciton from UI can consider to focus more on the rendering, e.g. different sized devices, performance, results layout etc.
```
