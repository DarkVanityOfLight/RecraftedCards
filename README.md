# RecraftedCards
This is a minecraft spigot/bukkit plugin to provide information for 
a player using a Character Card. This plugin is intended for usage
on roleplay servers. You can specify all fields you want, and their data type in the config.

## Configuration
The behaviour of character cards, their content and the way data should be
stored can be specified in the `config.yml` file.

### To specify the default display type
`defaultMode: TEXT` also possible is `GUI` instead of text,
but this feature is not implemented yet.

### To specify the way data is stored
`dataMode: YML` also possible is `SQL` but this feature is not implemented yet.

### To specify the fields of the CharacterCard
```yaml
fields:
    field1: <TYPE>
    field2: <TYPE>
    field3: <TYPE>
```
Possible values for the type are:
* BYTE
* SHORT
* INT
* LONG
* FLOAT
* DOUBLE
* BOOLEAN
* STRING\
Everything except INT and STRING is still experimental
and might not work at all.

### An example config file might look like that
```yaml
defaultMode: TEXT
dataMode: YML
fields:
    Name: String
    Age: INT
    Sex: String
```
