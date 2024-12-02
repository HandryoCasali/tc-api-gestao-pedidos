# API Expected Flow Documentation

## Expected User Journey:

### **Customer**

#### **Step 1: Criação de um Cliente (necessario == true)** (`POST /customer`)
O fluxo começa com a criação de um cliente no sistema.

#### **Request Body:**
```json
{
  "name": "Luis",
  "cpf": "46093823857",
  "email": "luis@gmail.com"
}
```

#### **Response:**
- **Status Code:** `201 Created`
- **Response Body:**
```json
{
  "id": 1,
  "name": "Luis",
  "cpf": "46093823857",
  "email": "luis@gmail.com"
}
```

#### **Step 2: Consulta de Cliente pelo CPF** (`GET /customer/{cpf}`)
Depois da criação, o usuário pode consultar os dados do cliente com base no CPF.

#### **Response:**
- **Status Code:** `200 OK`
- **Response Body:**
```json
{
  "id": 1,
  "name": "Luis",
  "cpf": "46093823857",
  "email": "luis@gmail.com"
}
```

---

### **Product**

#### **Step 3: Consulta de Produtos por Categoria** (`GET /product?categoryName=LANCHE`)
O usuário pode buscar produtos por categoria, como "LANCHE".

##### **Enum para Categorias Disponíveis:**
- **LANCHE**: "Lanche"
- **ACOMPANHAMENTO**: "Acompanhamento"
- **BEBIDAS**: "Bebidas"
- **SOBREMESA**: "Sobremesa"

##### **Response:**
- **Status Code:** `200 OK`
- **Response Body:**
```json
[
  {
    "id": 1,
    "name": "X-Tudo",
    "description": "Lanche com tudo",
    "price": 25,
    "discountPercent": 0,
    "productCategoryName": "LANCHE"
  }
]
```

---

### **Addon**

#### **Step 4: Consulta de Adicionais por Categoria** (`GET /addon?categoryName=LANCHE`)
Ao selecionar um produto, o usuário pode buscar adicionais disponíveis por categoria.

##### **Response:**
- **Status Code:** `200 OK`
- **Response Body:**
```json
[
  {
    "id": 1,
    "name": "Hamburguer",
    "price": 2.5,
    "discountPercent": 0,
    "productCategoryName": "LANCHE"
  }
]
```

---

### **Order**

#### **Step 4: Criação de Pedido** (`POST /order`)

O usuário pode criar um pedido contendo produtos e combos, especificando o tipo de pagamento e o cliente.

##### **Enum para PaymentType Disponíveis:**
- **PIX**: "Pix"
- **CREDITCARD**: "CreditCard"

##### **Request Body:**
```json
{
  "combos": [
    {
      "productId": 1, 
      "addonsId": [1]
    }
  ],
  "paymentType": "Pix",
  "customerId": 1
}
```

##### **Response:**
- **Status Code:** `201 Created`
- **Response Body:**
```json
{
  "id": 1,
  "orderStatus": "CREATED",
  "totalPrice": 27.5
}
```

---
### **Payment**

#### **Step 5: Obter pagamento** (`GET /paymentOrder?orderId={id}`)

O usuário pode obter o pagamento a partir do id do pedido.

##### **Response:**
- **Status Code:** `200 OK`
- **Response Body:**
```json
{
  "id": 1,
  "paymentStatusName": "Pending",
  "totalPrice": 100,
  "paymentTypeName": "Pix",
  "qrCode": "00020101021243650016COM.MERCADOLIBRE020130636530f1356-1157-etc"
}
```

Após o pagamento ser realizado, o mercado pago irá enviar um POST no endpoint "/paymentOrder/makePayment" da nossa aplicação e o sistema irá atualizar o status do pagamento para "Finished" e o pedido para "Received".

---

### **Flow Overview:**
1. **Criação de Cliente**: O primeiro passo é cadastrar o cliente. (se necessario)
2. **Consulta de Cliente**: O cliente pode ser consultado com base no CPF para verificar seus dados.
3. **Consulta de Produtos**: O usuário pode explorar o catálogo de produtos filtrando por categorias (ex.: Lanches, Bebidas, etc.).
4. **Consulta de Adicionais**: Após selecionar um produto, o usuário pode listar os adicionais disponíveis, como ingredientes extras.
5. **Criação de Pedido**: O pedido é criado, com produtos e adicionais, além do método de pagamento (Pix ou CreditCard).

---

Este flow descreve uma sequência comum de operações esperadas, mas os usuários podem realizar essas operações em qualquer ordem ou pular etapas conforme necessário.
