# graphql-springboot-mybatis
GraphQLでAPIを実装

## Language
Java17

## Framework
SpringBoot 3.0.4

## Database
- H2 Database
    - インメモリ

## ORM
mybatis 3.5

## GraphiQL
GraphiQL（グラフィカル）はGraphQLクエリを作成、編集、テストするためのWebベースのインタラクティブな統合開発環境。 
http://localhost:8080/graphiqls

```graphql
query {
    fetchEmployeeById(employeeId: "dummy") {
        employeeId
        employeeName
        gender
        department{
            departmentId
            departmentName
        }
        personal {
            employeeId
            birthday
            telephoneNumber
            mailAddress
        }
        historyList {
            startDate
            employeeId
            departmentId
            content
        }
        
    }
}
```
```graphql
query {
  fetchEmployeeAll {
    employeeId
    employeeName
    gender
    department{
      departmentId
      departmentName
    }
    personal {
      employeeId
      birthday
      telephoneNumber
      mailAddress
    }
    historyList {
      startDate
      employeeId
      departmentId
      content
    }
  }
}
```
```graphql
mutation {
  createEmployee(input: {
    employeeId: "graphql",
    departmentId: 4,
    employeeName: "graphql test",
    gender: "MALE",
    birthday: "2022-01-01"
    telephoneNumber: "00000000000"
    mailAddress: "graphql@graphql.com"
    historyList: {
        startDate: "2022-01-01"
        employeeId: "graphql"
        departmentId: 2
        content: "graphql 入社"
    } 
  }) {
    employeeId
    employeeName
    department {
      departmentId
      departmentName
    }
    gender
    personal {
      employeeId
      birthday
      telephoneNumber
      mailAddress
    }
    historyList {
      employeeId
      startDate
      departmentId
      content
    }
  }
}
```
```graphql
mutation {
  updateEmployee(employeeId: "graphql", input: {
    employeeId: "graphql",
    departmentId: 3,
    employeeName: "graphql-update",
    gender: "FEMALE",
    birthday: "2022-02-02"
    telephoneNumber: "00000000000"
    mailAddress: "graphql-update@graphql.com"
    historyList: [
        {
            employeeId: "graphql",
            startDate: "2022-01-01",
            departmentId: 2,
            content: "graphql 入社 UPDATE"
        }
        ,{
            employeeId: "graphql",
            startDate: "2022-02-02",
            departmentId: 3,
            content: "graphql 異動"
        }
        ]
  }) {
    employeeId
    employeeName
    department {
      departmentId
      departmentName
    }
    gender
    personal {
      employeeId
      birthday
      telephoneNumber
      mailAddress
    }
    historyList {
      employeeId
      startDate
      departmentId
      content
    }
  }
}
```
```graphql
mutation {
    deleteEmployee(employeeId: "dummy")
}
```