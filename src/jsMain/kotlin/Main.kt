import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        App()
    }
}

@Composable
fun App() {
    var count by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

    Div({
        style {
            fontFamily("Arial, sans-serif")
            padding(20.px)
            maxWidth(800.px)
            //margin(0.px, Style.Auto)
        }
    }) {
        H1({
            style {
                color(Color("#2196F3"))
                textAlign("center")
            }
        }) {
            Text("Welcome to Kotlin Compose HTML")
        }

        Div({
            style {
                backgroundColor(Color("#f5f5f5"))
                padding(20.px)
                borderRadius(8.px)
                marginBottom(20.px)
            }
        }) {
            H2 { Text("Interactive Counter") }
            P { Text("Current count: $count") }

            Button({
                style {
                    backgroundColor(Color("#4CAF50"))
                    color(Color.white)
                    border(0.px)
                    padding(10.px, 20.px)
                    borderRadius(4.px)
                    cursor("pointer")
                    marginRight(10.px)
                }
                onClick { count++ }
            }) {
                Text("Increment")
            }

            Button({
                style {
                    backgroundColor(Color("#f44336"))
                    color(Color.white)
                    border(0.px)
                    padding(10.px, 20.px)
                    borderRadius(4.px)
                    cursor("pointer")
                }
                onClick { count-- }
            }) {
                Text("Decrement")
            }
        }

        Div({
            style {
                backgroundColor(Color("#e3f2fd"))
                padding(20.px)
                borderRadius(8.px)
                marginBottom(20.px)
            }
        }) {
            H2 { Text("Name Input") }
            Input(InputType.Text) {
                value(name)
                onInput { name = it.value }
                placeholder("Enter your name...")
                style {
                    padding(8.px)
                    border(1.px, LineStyle.Solid, Color("#ddd"))
                    borderRadius(4.px)
                    width(200.px)
                    marginBottom(10.px)
                }
            }
            if (name.isNotEmpty()) {
                P({
                    style {
                        fontWeight("bold")
                        color(Color("#1976D2"))
                    }
                }) {
                    Text("Hello, $name!")
                }
            }
        }

        Div({
            style {
                backgroundColor(Color("#fff3e0"))
                padding(20.px)
                borderRadius(8.px)
            }
        }) {
            H2 { Text("Features Demonstrated") }
            Ul {
                Li { Text("Reactive state management with remember and mutableStateOf") }
                Li { Text("Event handling (onClick, onInput)") }
                Li { Text("CSS styling with type-safe DSL") }
                Li { Text("Conditional rendering") }
                Li { Text("Form inputs and user interaction") }
            }
        }
    }
}