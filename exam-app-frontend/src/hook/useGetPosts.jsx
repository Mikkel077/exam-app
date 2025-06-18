// src/api/posts.js
import axios from "axios";
import {useQuery} from "@tanstack/react-query";

export default function useGetPosts() {

    const BASE_URL = "/api/post";

    const getPosts = async () => {
        const response = await axios.get(BASE_URL);
        return response.data;
    }

    const {data: posts = [], error, isLoading} = useQuery({
        queryFn: getPosts,
        queryKey: "posts",
    })

    return (
        {
            posts,
            error,
            isLoading,
        }
    )
}