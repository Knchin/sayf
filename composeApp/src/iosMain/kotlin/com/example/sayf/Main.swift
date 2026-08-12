import UIKit
import shared

@main
struct SayfApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ContentView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}