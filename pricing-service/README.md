REST API returning cost for rental

## Example usage

```
curl -X POST -H 'Content-Type:application/json' -d '{"plan":"basic", "start": "2011-12-03T10:15:30+01:00","end" : "2011-12-05T12:15:30+01:00"}' http://localhost:8080/v1/prices
```

returns

```
{"price":0}
```