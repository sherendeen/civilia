# civilia
Unfinished attempted implementation of a Civilization clone in java using javafx. It is from about a year ago at least.
It does not do much and pales in comparison, in terms of functionality, to another project that I contributed to called BraveNewWorld. I will in time upload that to Github.

Civilia has many problems:
- Clicking on a tile on the map generates an NPE. When I had designed it, I had intended for the user to be able to click on a given tile to "select" it. Only half of that was accomplished: you can click on a tile but the game is unable to determine WHERE it is in the tileMap array. This was a problem solved in the C# implementation BraveNewWorld that I had helped make with Jonah Posey.
- Unimplemented save/load functionality
- Looking back, I would have used enumerated types for describing terrain.

# Licenses
The entirety of the code for Civilia is licensed with the MIT license. See LICENSE-MIT.MD

The entirety of the images included in the images directory are hereby licensed with Attribution 4.0 International (CC BY 4.0). https://creativecommons.org/licenses/by/4.0/
