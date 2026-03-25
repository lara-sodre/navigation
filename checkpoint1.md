#composable(route = "perfil/{nome}")  - criando uma rota de navegação no Jetpack Compose Navigation.
#"perfil/{nome}" significa que essa tela espera um parâmetro dinâmico chamado nome.

#val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
#it: representa o NavBackStackEntry, ou seja, o contexto da rota atual.
#it.arguments: contém os parâmetros passados pela navegação.
#getString("nome", "Usuário Genérico"): Tenta pegar o valor do argumento "nome" e se não existir, usa "Usuário Genérico" como padrão.
#String?: porque pode ser nulo.

#PerfilScreen(
modifier = Modifier.padding(innerPadding),
navController,
nome!!
) - Composable chamado PerfilScreen.
#modifier = Modifier.padding(innerPadding): Aplica um espaçamento interno na tela.
#navController: Permite navegar entre telas.
#nome!!: !! significa: "tenho certeza que não é nulo"


#onClick = { navController.navigate("perfil/Fulano de Tal") }:
#onClick = { ... }: o que acontece quando o usuário clica em um botão ou componente.
#navController.navigate(...): manda o app navegar para outra tela.
#"perfil/Fulano de Tal":  a rota que você criou antes (perfil/{nome}), passando o valor "Fulano de Tal" como argumento.


#fun PerfilScreen(
modifier: Modifier = Modifier,
navController: NavController,
nome: String
) {:
#modifier: Modifier = Modifier: customizar o layout
#navController: NavController: Controla a navegação entre telas.
#nome: String: É o nome recebido.


#text = "PERFIL - $nome":
#O $nome insere o valor da variável nome dentro da string.



#composable(
route = "pedidos?cliente={cliente}",
arguments = listOf(navArgument("cliente") {
defaultValue = "Cliente Genérico"
})
) {
PedidosScreen(modifier = Modifier.padding(innerPadding), navController, it.arguments?.getString("cliente")):

#composable(
route = "pedidos?cliente={cliente}": uma rota com query parameter (?cliente=...).

#arguments = listOf(navArgument("cliente") {
defaultValue = "Cliente Genérico"
}): Define o argumento "cliente". Se não for enviado: usa "Cliente Genérico" automaticamente.

#it.arguments?.getString("cliente"): Pega o valor passado na navegação.



#PerfilScreen(
modifier = Modifier.padding(innerPadding),
navController,
nome!!): Você está chamando a função PerfilScreen e passando 3 parâmetros:
#modifier: Aplica um padding na tela.
#navController: Permite navegar entre telas.


#PedidosScreen -> cliente: String?:cliente é uma variável/parâmetro do tipo String que pode ser nula.
#text = "PEDIDOS - $cliente": Define um texto exibido na tela (geralmente em um Text no Jetpack Compose).


MenuScreen -> onClick = { navController.navigate("pedidos?cliente=Cliente XPTO") },  colors = ButtonDefaults.buttonColors(Color.White):
    #O app navega para a rota "pedidos" e envia o parâmetro cliente = "Cliente XPTO".



#MainActivity ->  composable(
route = "perfil/{nome}/{idade}",
arguments = listOf(
navArgument("nome") { type = NavType.StringType },
navArgument("idade") { type = NavType.IntType }
)
) {: 
#onClick → ação ao clicar no botão (navega para outra tela)
#navController.navigate(...) → faz a navegação
#"pedidos?cliente=..." → rota com parâmetro opcional (cliente)
#navArgument + defaultValue → define valor padrão se nada for enviado
#it.arguments?.getString("cliente") → pega o valor recebido (pode ser null)
#cliente: String? → parâmetro que pode ser texto ou null
#PedidosScreen(...) → tela que recebe o valor
#"PEDIDOS - $cliente" → exibe o nome na tela
#cliente ?: "Cliente Genérico" → evita aparecer null


#val idade: Int? = it.arguments?.getInt("idade", 0):
#val idade: Int? → variável do tipo inteiro que pode ser nulo
#it.arguments → argumentos recebidos da navegação
#?. → acesso seguro (evita erro se for null)
#getInt("idade", 0) → pega o valor de idade
#0 → valor padrão se não existir argumento

#No MainActivity -> nome!!, idade!!:
#nome!! → força o valor de nome a não ser null
#idade!! → força o valor de idade a não ser null
#!! → operador de não-nulo no Kotlin


#No MenuScreen: onClick = { navController.navigate("perfil/Fulano de Tal/27") }:
#onClick → ação ao clicar no botão
#navController.navigate(...) → faz a navegação
#"perfil/Fulano de Tal/27" → rota com parâmetros
#Fulano de Tal → valor do nome
#27 → valor da idade


#No PerfilScreen -> nome: String, idade: Int: 
#nome: String → parâmetro obrigatório do tipo texto (não pode ser null)
#idade: Int → parâmetro obrigatório do tipo número inteiro (não pode ser null)

#text = "PERFIL - $nome tem $idade anos":
#text = "PERFIL - $nome tem $idade anos" → define o texto exibido na tela
#$nome → insere o nome na string
#$idade → insere a idade na string
#Interpolação de string → mistura texto fixo com variáveis