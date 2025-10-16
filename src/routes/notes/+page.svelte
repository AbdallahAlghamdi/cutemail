<script lang="ts">
    import { Editor } from "@tiptap/core";
    import { StarterKit } from "@tiptap/starter-kit";
    import { onDestroy, onMount } from "svelte";

    let element = $state<Element>();
    let editorState = $state({ editor: null });
    let editor = $state<Editor | null>();
    onMount(() => {
        editor = new Editor({
            element: element,
            extensions: [StarterKit],
            content: `
        <h1>Hello Svelte! 🌍️ </h1>
        <p>This editor is running in Svelte.</p>
        <p>Select some text to see the bubble menu popping up.</p>
      `,
            onTransaction: ({ editor }) => {
                // force re-render so `editor.isActive` works as expected
                editorState = { editor };
            },
        });
    });
    onDestroy(() => {
        if (editor) editor.destroy();
    });
</script>

<div style="position: relative" class="app">
    {#if editorState.editor}
        <div class="fixed-menu">
            <button
                onclick={() =>
                    editorState.editor
                        .chain()
                        .focus()
                        .toggleHeading({ level: 1 })
                        .run()}
                class:active={editorState.editor.isActive("heading", {
                    level: 1,
                })}
            >
                H1
            </button>
            <button
                onclick={() =>
                    editorState.editor
                        .chain()
                        .focus()
                        .toggleHeading({ level: 2 })
                        .run()}
                class:active={editorState.editor.isActive("heading", {
                    level: 2,
                })}
            >
                H2
            </button>
            <button
                onclick={() =>
                    editorState.editor.chain().focus().setParagraph().run()}
                class:active={editorState.editor.isActive("paragraph")}
            >
                P
            </button>
        </div>
    {/if}

    <div bind:this={element}></div>
</div>

<style>
    button.active {
        background: black;
        color: white;
    }
</style>
