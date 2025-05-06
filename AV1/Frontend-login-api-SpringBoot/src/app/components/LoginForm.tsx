"use client";
import { useState } from "react";

export default function LoginForm() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    // Verificando os dados que serão enviados
    console.log("Dados do login: ", { email, senha });

    try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                email: email,
                senha: senha,
            }),
        });

        const result = await response.text();
        console.log("Resposta do servidor:", result); // Logando a resposta do servidor

        if (response.ok) {
            alert(result);
            window.location.href = "/bem-vindo";
        } else {
            alert("Erro de login: " + result);
        }
    } catch (error) {
        alert("Erro ao fazer login.");
        console.error("Erro:", error);
    }
};

  
  
  

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-4">
        <label>Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
          className="border rounded w-full p-2"
        />
      </div>
      <div className="mb-4">
        <label>Senha:</label>
        <input
          type="password"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
          required
          className="border rounded w-full p-2"
        />
      </div>
      <button
        type="submit"
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        Entrar
      </button>
    </form>
  );
}
