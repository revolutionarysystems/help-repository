Help Repository
===============

### Retrieve the root of the repository

```sh
curl --user username:password "http://localhost:8080/help-repository/"

curl "http://localhost:8080/public/{accountId}/"
```

```json
{
	"path": "/",
	"name": "",
	"parent": null,
	"created": null,
	"createdBy": null,
	"modified": null,
	"modifiedBy": null,
	"contentType": "rcr/container",
	"children": [{
		"contentType": "help/item",
		"path": "/Test_Item_1",
		"name": "Test_Item_1"
	}, {
		"contentType": "help/link",
		"path": "/Test_Link_1",
		"name": "Test_Link_1"
	}, {
		"contentType": "rcr/container",
		"path": "/Test_Container_1",
		"name": "Test_Container_1"
	}, {
		"contentType": "rcr/binary",
		"path": "/test.xml",
		"name": "test.xml"
	}]
}
```

This returns the "children" nodes of the root node in the repository. There are 4 types of nodes that could be returned and these can be identified by their contentType.

**help/item** - This is a node that represents a help item.
**help/link** - This represents a link to an external resource
**rcr/binary** - This represents a binary file
**rcr/container** - This node is a container for other nodes. The root node for example is of contentType of "rcr/container".

### Retrieving a Help Item

```sh
curl --user username:password "http://localhost:8080/help-repository/Test_Item_1"

curl "http://localhost:8080/public/{accountId}/Test_Item_1"
```

```json
{
	"path": "/Test_Item_1",
	"name": "Test_Item_1",
	"parent": "/",
	"created": 1409928605912,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410264250664,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "help/item",
	"children": [{
		"contentType": "rcr/binary",
		"path": "/Test_Item_1/test.xml",
		"name": "test.xml"
	}],
	"properties": {
		"title": "Test Item 1",
		"text": "<p>This <strong>is</strong> a test</p>"
	}
}
```

Help items can also contain children nodes of type "rcr/binary" or "help/link".

### Retrieving a Link

```sh
curl --user username:password "http://localhost:8080/help-repository/Test_Link_1"

curl "http://localhost:8080/public/{accountId}/Test_Link_1"
```

```json
{
	"path": "/Test_Link_1",
	"name": "Test_Link_1",
	"parent": "/",
	"created": 1409929052853,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410264238792,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "help/link",
	"properties": {
		"title": "Test Link 1",
		"url": "www.revolutionarysystems.co.uk"
	}
}
```

### Retrieving a Binary File

You can make 2 requests for a binary file. You can either make a request to get the meta data about the file.

```sh
curl --user username:password "http://localhost:8080/help-repository/test.xml"

curl "http://localhost:8080/public/{accountId}/test.xml"
```

```json
{
	"path": "/test.xml",
	"name": "test.xml",
	"parent": "/",
	"created": 1410343355013,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410343355014,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "rcr/binary",
	"mimeType": "text/xml"
}
```

Or you can request the file itself.

```sh
curl --user username:password "http://localhost:8080/help-repository/binary/test.xml"

curl "http://localhost:8080/public/{accountId}/binary/test.xml"
```

```xml
<test>
    <foo>123</foo>
    <bar>456</bar>
</test>
```

### Search the repository

```sh
curl "http://localhost:8080/help-repository/query?query=Test&offset=0&limit=20"

curl "http://localhost:8080/public/{accountId}/query?query=Test&offset=0&limit=20"
```

```json
[{
	"score": 1.0,
	"path": "/Test_Link_1",
	"name": "Test_Link_1",
	"parent": "/",
	"created": 1409929052853,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410264238792,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "help/link",
	"properties": {
		"title": "Test Link 1",
		"url": "www.revolutionarysystems.co.uk"
	}
}, {
	"score": 1.0,
	"path": "/Test_Item_1",
	"name": "Test_Item_1",
	"parent": "/",
	"created": 1409928605912,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410264250664,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "help/item",
	"children": [{
		"contentType": "rcr/binary",
		"path": "/Test_Item_1/test.xml",
		"name": "test.xml"
	}],
	"properties": {
		"title": "Test Item 1",
		"text": "<p>This <strong>is</strong> a test2</p>"
	}
},{
	"score": 1.0,
	"path": "/test.xml",
	"name": "test.xml",
	"parent": "/",
	"created": 1410343355013,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410343355014,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "rcr/binary",
	"mimeType": "text/xml"
}, {
	"score": 1.0,
	"path": "/testing/test.xml",
	"name": "test.xml",
	"parent": "/testing",
	"created": 1410341751117,
	"createdBy": {
		"id": "",
		"name": ""
	},
	"modified": 1410342919253,
	"modifiedBy": {
		"id": "",
		"name": ""
	},
	"contentType": "rcr/binary",
	"mimeType": "text/xml"
}]
```

The "limit" and "offset" parameters are optional. If omitted the query will return all matching results.