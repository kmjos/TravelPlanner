<#if prevNode == "san francisco" >
Having just seen one of California's great cities, prepare yourself for another!
</#if>
<#if 3 < hikingCnt && interest == "hiking">
Since you've enjoyed sight seeing in so many other parts of California, you're sure to enjoy your time in Los Angeles.
</#if>
<#if 3 < fishCnt && interest == "fishing">
People don't usually associate fishing with Los Angeles, but an avid fisherman such as yourself won't let that stop
you!
</#if>
<#if 3 < artCnt && interest == "arts" && currNode == destinationNode >
Now that you've sampled the artistic side of a number of other California destinations, Los Angeles is sure to be a
great ending to your trip.
</#if>
<#if currNode != destinationNode>
Upon arriving in Los Angeles, you’ll spend an exciting two days touring the city. You’ll tour Beverly Hills and
take a trip to walk beneath the Hollywood sign.
<#if interest == "hiking" >
On the second day, you’ll visit the La Brea tar pits and see woolly mammoth and saber tooth cats. You’ll then visit
the Santa Monica Pier before retiring for the night.
</#if>
<#if interest == "arts" >
Afterwards, you'll visit the Los Angeles County Museum of Art to see the finest collection of art in the city. You’ll
then visit the Santa Monica Pier before retiring for the night.
</#if>
<#if interest == "fishing" >
On the second day, you’ll try your luck with salt water fishing on the Venice Fishing Pier before taking an evening
stroll on the Santa Monica Pier and retiring for the night.
</#if>
</#if>
<#if currNode == destinationNode>
Even though your trip is coming to an end, there's still plenty to see and do in Los Angeles!
Upon arriving in Los Angeles, you'll have time to explore the city on your own before your departure.  Check out
Hollywood Boulevarde and snap some pictures next to the stars of your favorite celebrities.  Visit the Chinese Theatre or
spend a day enjoying the rides in Disney Land. Whatever you choose to do here in LA, as your trip comes to a close,
you're sure to spend some time remembering the fun you've had in California.
</#if>