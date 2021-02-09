# dadic (data dictionary)
Start from a domain model consisting of simple POJOs.

Annotate some fields with @DictionaryElement.

Apply some Calculations that are java implementations or backed by simple data structures (e.g. table lookups).

End up with the POJO annotated fields having calculated values, as well as some additional calculations that were really a byproduct of the process, but may be of use to you later on!

# TODOs
1. Add additional Calculation options (e.g. formulas).
1. Implement DataProvider (e.g. with database storage and String value serialization) and think about caching.
1. Add a UI.
1. ???
1. Profit. 
