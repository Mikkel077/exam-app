import React from "react";
import "./App.css";
import useGetPosts from "./hook/useGetPosts.jsx";

function App() {
    const {posts, isLoading, error} = useGetPosts();

    if (isLoading) {
        return <p>Loading posts…</p>;
    }
    if (error) {
        return <p style={{color: "red"}}>Error loading posts: {error.message}</p>;
    }
    if (posts.length === 0) {
        return <p>No posts returned.</p>;
    }

    return (
        <div className="w-min- max-w-4xl mx-auto p-4">
            <ul className="bg-base-100 rounded-box shadow-md divide-y divide-gray-200">
                {posts.map((post) => (
                    <li className="flex flex-wrap justify-between items-center py-3 px-4">
                        <div className="w-full sm:w-1/3">
                            <div className="text-xs uppercase font-semibold opacity-60">Content</div>
                            <div>{post.content}</div>
                        </div>
                        <div className="w-full sm:w-1/3">
                            <div className="text-xs uppercase font-semibold opacity-60">Department</div>
                            <div>{post.department}</div>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
