<#if prevNode == "los angeles" >
Having just seen one of California's great cities, prepare yourself for another!
</#if>
<#if prevNode == "death valley" >
From the sunny desert beauty of Death Valley to the foggy bay of San Francisco, a few hours drive makes a huge difference!
But once the fog lifts you'll see the stunning bay views and you'll know why San Francisco is such a popular destination.
</#if>
<#if 3 < hikingCnt && interest == "hiking">
Now that you've enjoyed sight seeing in so many other parts of California, you're sure to love the eclectic mix of urban
and scenic points of interest in the iconic City by the Bay.
</#if>
<#if 3 < fishCnt && interest == "fishing">
You've already seen that the rest of California has a lot to offer an avid fisherman like yourself, and San Francisco
won't let you down either!
</#if>
<#if 3 < artCnt && interest == "arts" && remainingTripLength <= 3 >
You've seen the artistic side of other spots in California, now you're in for a treat. San Francisco is a haven for
artists!
</#if>
<#if currNode != destinationNode>
Upon arriving in San Francisco, you’ll get a chance to immerse yourself in the beautiful city by taking a ride on the
classic trolley through downtown San Francisco followed by a guided tour of Chinatown.
<#if interest == "hiking" >
The second day of your trip you’ll visit Fisherman’s Wharf to observe the resident sea life and browse through the
quaint shops before enjoying a delicious sundae at the chocolate factory in Ghiradelli Square.
</#if>
<#if interest == "arts" >
The second day of your trip you’ll visit the Presidio, followed by a trip to the Fine Art Museum and the San Francisco
Art Market.
</#if>
<#if interest == "fishing" >
The second day of your trip you’ll visit Fisherman’s Wharf to observe the resident sea life and go out on a chartered
fishing boat into San Francisco Bay.
</#if>
</#if>
<#if currNode == destinationNode>
Even though your trip is coming to an end, there's still plenty to see and do in San Francisco! You'll soon find out
that New York isn't the only city that never sleeps.
Upon arriving in San Francisco, you'll have time to explore the city on your own before your departure.  Enjoy the cool
breeze off the ocean as you check out the San Francisco Zoo. Spend a day in Golden Gate Park and visit the Battery or the
Science Center before spending a night on the town at Castro Street. Whatever you choose to do here in San Francisco,
as your trip comes to a close, you're sure to spend some time remembering the fun you've had in California.
</#if>