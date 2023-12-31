import {defineConfig} from "vite";
import path from "path";

export default defineConfig({
    plugins: [],
    build: {
        manifest: true,
        outDir: path.resolve(__dirname, "build"),
        emptyOutDir: true,
        rollupOptions: {
            input: {
                app: path.resolve(__dirname, "js/app.js"),
            },
        },
    },
});
