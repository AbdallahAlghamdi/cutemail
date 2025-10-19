<script lang="ts">
    import { Editor } from "@tiptap/core";
    import { StarterKit } from "@tiptap/starter-kit";
    import { onDestroy, onMount } from "svelte";
    import ToolBarButton from "./ToolBarButton.svelte";

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

<div style="position: relative">
    {#if editorState.editor}
        <section>
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleBold().run()}
                checked={editorState.editor.isActive("bold")}
                label="bold"
                content="B"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                content="I"
                content_active="/"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                content="H1"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                content="H2"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                content="H3"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                content="<>"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                image="/icons/toolbar/justify-right.png"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                image="/icons/toolbar/justify-center.png"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                image="/icons/toolbar/justify-fill.png"
            />
            <ToolBarButton
                onclick={() =>
                    editorState.editor.chain().focus().toggleItalic().run()}
                checked={editorState.editor.isActive("italic")}
                label="bold"
                image="/icons/toolbar/justify-left.png"
            />
        </section>
    {/if}
</div>
<div class="editor" bind:this={element}></div>

<style>
    .banner {
        border-style: solid;
        border-image: url("/srtoasty/brown-banner.png");

        border-image-slice: 4 4 4 4 fill;
        border-image-width: calc(16px / 2);
        padding: 16px;
        margin: 6px;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 25px;
    }
    section {
        display: flex;
        justify-content: center;
        gap: 3px;
        padding: 16px;
    }

    .editor {
        border-image: url("/srtoasty/notebook-paper.png") round round;
        border-style: solid;
        flex-grow: 1;
        border-image-slice: 16 16 16 16 fill;
        border-image-width: calc(48px / 2);
        margin: 8px;
        padding-left: 15px;
        padding-right: 10px;
        height: 100px;

        /* border-image: url("/srtoasty/notebook-paper.png");
        height: 100%;
        border-image-slice: 16 16 16 16 fill;
        border-image-width: calc(48px / 2);
        padding: 16px; */
    }
</style>
