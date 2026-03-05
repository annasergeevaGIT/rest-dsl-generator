service UserService {

  endpoint GET /users -> User
  endpoint GET /users/{id} -> User
  endpoint POST /users(UserRequest) -> User
}