<script lang="ts">
    import { onMount } from "svelte";
    import type { Readable } from "svelte/store";
    import { createEditor, Editor, EditorContent } from "svelte-tiptap";
    import StarterKit from "@tiptap/starter-kit";
    import ToolBarButton from "$lib/componets/ToolBarButton.svelte";
    import TextAlign from "@tiptap/extension-text-align";

    let editor = $state() as Readable<Editor>;

    onMount(() => {
        editor = createEditor({
            element: document.getElementById("tiptap"),
            extensions: [
                StarterKit,
                TextAlign.configure({
                    types: ["heading", "paragraph"],
                }),
            ],

            content: `Hello world!`,
            onTransaction: () => (editor = editor),
        });
    });
</script>

<p class="banner">Test</p>
<div class="editor">
    {#if editor}
        <div class="toolbar">
            <section class="decoration">
                <ToolBarButton
                    onclick={() => $editor.chain().focus().toggleBold().run()}
                    checked={$editor.isActive("bold")}
                    label="bold"
                    content="B"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().toggleUnderline().run()}
                    checked={$editor.isActive("underline")}
                    label="underline"
                    content="U"
                />
                <ToolBarButton
                    onclick={() => $editor.chain().focus().toggleStrike().run()}
                    checked={$editor.isActive("underline")}
                    label="Underline"
                    content="S"
                    content_active="S"
                />
                <ToolBarButton
                    onclick={() => $editor.chain().focus().toggleItalic().run()}
                    checked={$editor.isActive("italic")}
                    label="bold"
                    content="I"
                    content_active="/"
                />
            </section>
            <section>
                <ToolBarButton
                    onclick={() =>
                        $editor
                            .chain()
                            .focus()
                            .toggleHeading({ level: 1 })
                            .run()}
                    checked={$editor.isActive("heading", { level: 1 })}
                    label="Heading 1"
                    content="H1"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor
                            .chain()
                            .focus()
                            .toggleHeading({ level: 2 })
                            .run()}
                    checked={$editor.isActive("heading", { level: 2 })}
                    label="Heading 2"
                    content="H2"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor
                            .chain()
                            .focus()
                            .toggleHeading({ level: 3 })
                            .run()}
                    checked={$editor.isActive("heading", { level: 3 })}
                    label="Heading 3"
                    content="H3"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().toggleCodeBlock().run()}
                    checked={$editor.isActive("codeBlock")}
                    label="bold"
                    content="<>"
                />
            </section>
            <section class="justify">
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().setTextAlign("justify").run()}
                    checked={$editor.isActive({ textAlign: "justify" })}
                    label="justify fill"
                    image="/icons/toolbar/justify-fill.png"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().setTextAlign("center").run()}
                    checked={$editor.isActive({ textAlign: "center" })}
                    label="center text"
                    image="/icons/toolbar/justify-center.png"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().setTextAlign("right").run()}
                    checked={$editor.isActive({ textAlign: "right" })}
                    label="justify right"
                    image="/icons/toolbar/justify-right.png"
                />
                <ToolBarButton
                    onclick={() =>
                        $editor.chain().focus().setTextAlign("left").run()}
                    checked={$editor.isActive({ textAlign: "left" })}
                    label="justify left"
                    image="/icons/toolbar/justify-left.png"
                />
            </section>
        </div>
    {/if}
    <div id="tiptap"></div>
</div>

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
    .editor {
        height: 100%;
        display: flex;
        overflow: hidden;
        flex-direction: column;
    }
    div section {
        flex-grow: 1;
        display: flex;
        gap: 2px;
        padding: 4px 0px;
        justify-content: center;
    }
    #tiptap {
        height: 100%;
        margin-bottom: 6px;
        overflow: hidden;
    }
    :global(pre) {
        background-color: #303843;
        border-radius: 0.25rem;
        padding: 5px;
        color: #d2deee;
        margin: 5px;
        margin-right: 15px;
    }
    :global(.tiptap) {
        height: 100%;
        overflow: scroll;
        margin-left: 7px;
        margin-right: 8px;
        padding-left: 15px;
        border-style: solid;
        border-image: url("/srtoasty/notebook-paper.png") round;
        border-image-slice: 16 16 16 16 fill;
        border-image-width: calc(48px / 2);
    }
    .toolbar {
        display: flex;
        justify-content: space-evenly;
        align-items: center;
        margin-left: 5px;
        margin-right: -1.5px;
        /* margin-left: 1px; */
    }
</style>
