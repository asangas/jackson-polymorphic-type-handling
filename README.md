POC - Polymorphic Type Handling (Serialisation/ Deserialisation) using Jackson
==============================================================================

POC to prove that Jackson can handle serialising/ deserialising of a JSON payload with minimal extra code.

### Class hierarchy used in this example

                   Asset
           _________|________
          |                   |
      FileAsset          YoutubeVideoAsset
          |
       PDFAsset
           

### Implementation
The following extra annotations were used:
1. `@JsonSubTypes`
2. `@JsonTypeInfo`

Refer to the class `au.com.reece.poc.model.Asset` on how the above annotations have been used, and `AssetTest` for the unit tests.

### Unknown types
The provider should be able to introduce new asset types **without breaking existing consumers**. 
This was achieved using the new type `UnknownFormatAsset` along with the `defaultImpl` attribute of the `@JsonTypeInfo` annotation.
 
 