import Link from "next/link";

export default function BemVindoPage() {
  return (
    <main className="flex min-h-screen items-center justify-center bg-gradient-to-br from-purple-200 to-white px-4">
      <div className="text-center bg-white p-8 rounded shadow-md max-w-md w-full">
        <h1 className="text-3xl font-bold text-gray-800 mb-4">
          Bem-vindo!
        </h1>
        <p className="text-gray-600 mb-6">
          Você fez login com sucesso.
        </p>
        <Link href="/">
          <button className="bg-purple-600 hover:bg-purple-700 text-white px-4 py-2 rounded">
            Voltar para a Home
          </button>
        </Link>
      </div>
    </main>
  );
}
