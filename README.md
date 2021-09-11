# RecraftedCards
This is a minecraft spigot/bukkit plugin to provide information for 
a player using a Character Card. This plugin is intended for usage
on roleplay servers. You can specify all fields you want in the config.

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
fields: [field1, field2, field3]
```
### Displaying permission bound titles
If a player has any permission starting with `charcars.custom` it will be displayed in his card.
The field name will be defined by the first node after the custom and the value for the field by the second node after
custom.  
`Note: More then two node after the custom will break something`  
_ will be replaced by spaces while parsing the permission, so `charcards.custom.title.King` would be displayed
as `title: King` and `charcards.custom.skill.basic_blacksmithing` as `skill: basic blacksmithing`.

### An example config file might look like that
```yaml
defaultMode: TEXT
dataMode: YML
fields: [Name, Age, Sex, Description]
```
### How to set infos
The player just has to call setField followed by the field name and then the value to set to
`/setField Age 13`

### How to display infos
The showCard command will display a card for a given player 
`/showCard Brotdosenterror_`