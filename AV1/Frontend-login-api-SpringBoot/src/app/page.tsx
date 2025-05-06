import Link from "next/link";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-center bg-gradient-to-br from-blue-200 to-white px-6">
      <div className="text-center">
        <h1 className="text-4xl font-bold text-gray-800 mb-4">
          Sistema de Login
        </h1>
        <p className="text-gray-600 mb-8">
          Bem-vindo! Faça login ou cadastre-se para começar.
        </p>

        <div className="flex flex-col sm:flex-row gap-4 justify-center">
          <Link href="/login">
            <button className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded shadow">
              Entrar
            </button>
          </Link>
          <Link href="/cadastro">
            <button className="bg-green-600 hover:bg-green-700 text-white px-6 py-2 rounded shadow">
              Cadastrar
            </button>
          </Link>
        </div>
      </div>
    </main>
  );
}
