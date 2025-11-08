<script lang="ts">
  import { onMount } from "svelte";
  import type { Readable } from "svelte/store";
  import Math, { migrateMathStrings } from "@tiptap/extension-mathematics";
  import { createEditor, Editor, EditorContent } from "svelte-tiptap";
  import StarterKit from "@tiptap/starter-kit";
  import ToolBarButton from "$lib/componets/ToolBarButton.svelte";
  import TextAlign from "@tiptap/extension-text-align";
  import { ListKit, TaskItem, TaskList } from "@tiptap/extension-list";

  let editor = $state() as Readable<Editor>;
  let note_title = $state("Hello Github!");

  onMount(() => {
    editor = createEditor({
      element: document.getElementById("tiptap"),
      extensions: [
        StarterKit,
        TextAlign.configure({
          types: ["heading", "paragraph"],
        }),
        TaskList,
        TaskItem.configure({
          nested: true,
        }),
        Math.configure({
          blockOptions: {
            onClick: (node, pos) => {
              const newCalculation = prompt(
                "Enter new calculation:",
                node.attrs.latex
              );
              if (newCalculation) {
                $editor
                  .chain()
                  .setNodeSelection(pos)
                  .updateBlockMath({ latex: newCalculation })
                  .focus()
                  .run();
              }
            },
          },
          inlineOptions: {
            onClick: (node) => {
              const newCalculation = prompt(
                "Enter new calculation:",
                node.attrs.latex
              );
              if (newCalculation) {
                $editor
                  .chain()
                  .updateInlineMath({ latex: newCalculation })
                  .focus()
                  .run();
              }
            },
          },
        }),
      ],

      content: `
      <h1>
        This editor supports <span data-type="inline-math" data-latex="\\LaTeX"></span> math expressions. And it even supports converting old $\\sub(3*5=15)$ calculations.
      </h1>
      <p>This is a old $\\LaTeX$ calculation string with $3*5=15$ calculations.</p>
      <p>
        Did you know that <span data-type="inline-math" data-latex="3 * 3 = 9"></span>? Isn't that crazy? Also Pythagoras' theorem is <span data-type="inline-math" data-latex="a^2 + b^2 = c^2"></span>.<br />
        Also the square root of 2 is <span data-type="inline-math" data-latex="\\sqrt{2}"></span>. If you want to know more about <span data-type="inline-math" data-latex="\\LaTeX"></span> visit <a href="https://katex.org/docs/supported.html" target="_blank">katex.org</a>.
      </p>
      <code>
        <pre>$\\LaTeX$</pre>
      </code>
      <p>
        Do you want go deeper? Here is a list of all supported functions:
      </p>
      <ul>
        <li><span data-type="inline-math" data-latex="\\sin(x)"></span></li>
        <li><span data-type="inline-math" data-latex="\\cos(x)"></span></li>
        <li><span data-type="inline-math" data-latex="\\tan(x)"></span></li>
        <li><span data-type="inline-math" data-latex="\\log(x)"></span></li>
        <li><span data-type="inline-math" data-latex="\\ln(x)"></span></li>
        <li><span data-type="inline-math" data-latex="\\sqrt{x}"></span></li>
        <li><span data-type="inline-math" data-latex="\\sum_{i=0}^n x_i"></span></li>
        <li><span data-type="inline-math" data-latex="\\int_a^b x^2 dx"></span></li>
        <li><span data-type="inline-math" data-latex="\\frac{1}{x}"></span></li>
        <li><span data-type="inline-math" data-latex="\\binom{n}{k}"></span></li>
        <li><span data-type="inline-math" data-latex="\\sqrt[n]{x}"></span></li>
        <li><span data-type="inline-math" data-latex="\\left(\\frac{1}{x}\\right)"></span></li>
        <li><span data-type="inline-math" data-latex="\\left\\{\\begin{matrix}x&\\text{if }x>0\\\\0&\\text{otherwise}\\end{matrix}\\right."></span></li>
      </ul>
      <p>The math extension also supports block level math nodes:</p>
      <div data-type="block-math" data-latex="\\int_a^b x^2 dx"></div>
    `,
      onTransaction: () => (editor = editor),
    });
  });
</script>

<section class="banner">
  <span class="title">{note_title}</span>
  <div class="actions">
    <a title="Go back to the notes list" href="/notes">
      <img src="/icons/piiixl/ui/notes.png" alt="exit" />
    </a>
    <img title="Settings" src="/icons/piiixl/ui/settings.png" alt="settings" />
    <img
      title="Delete note"
      src="/icons/piiixl/ui/trashcan-closed.png"
      alt="Delete"
    />
  </div>
</section>
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
          onclick={() => $editor.chain().focus().toggleUnderline().run()}
          checked={$editor.isActive("underline")}
          label="underline"
          content="U"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().toggleStrike().run()}
          checked={$editor.isActive("strike")}
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
          onclick={() => $editor.chain().focus().toggleBulletList().run()}
          checked={$editor.isActive("bulletList")}
          label="bold"
          image="/icons/toolbar/bullet-list.png"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().toggleOrderedList().run()}
          checked={$editor.isActive("orderedList")}
          label="bold"
          image="/icons/toolbar/ordered-list.png"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().toggleTaskList().run()}
          checked={$editor.isActive("taskList")}
          label="bold"
          image="/icons/toolbar/checkbox-list.png"
        />
      </section>
      <section>
        <ToolBarButton
          onclick={() =>
            $editor.chain().focus().toggleHeading({ level: 1 }).run()}
          checked={$editor.isActive("heading", { level: 1 })}
          label="Heading 1"
          content="L"
        />
        <ToolBarButton
          onclick={() =>
            $editor.chain().focus().toggleHeading({ level: 2 }).run()}
          checked={$editor.isActive("heading", { level: 2 })}
          label="Heading 2"
          content="M"
        />
        <ToolBarButton
          onclick={() =>
            $editor.chain().focus().toggleHeading({ level: 3 }).run()}
          checked={$editor.isActive("heading", { level: 3 })}
          label="Heading 3"
          content="S"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().toggleCodeBlock().run()}
          checked={$editor.isActive("codeBlock")}
          label="bold"
          content="<>"
        />
      </section>
      <section class="justify">
        <ToolBarButton
          onclick={() => $editor.chain().focus().setTextAlign("justify").run()}
          checked={$editor.isActive({ textAlign: "justify" })}
          label="justify fill"
          image="/icons/toolbar/justify-fill.png"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().setTextAlign("center").run()}
          checked={$editor.isActive({ textAlign: "center" })}
          label="center text"
          image="/icons/toolbar/justify-center.png"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().setTextAlign("right").run()}
          checked={$editor.isActive({ textAlign: "right" })}
          label="justify right"
          image="/icons/toolbar/justify-right.png"
        />
        <ToolBarButton
          onclick={() => $editor.chain().focus().setTextAlign("left").run()}
          checked={$editor.isActive({ textAlign: "left" })}
          label="justify left"
          image="/icons/toolbar/justify-left.png"
        />
      </section>
    </div>
  {/if}
  <div class="pixelCheckbox" id="tiptap"></div>
</div>

<style>
  .actions {
    gap: 5px;
    display: flex;
  }

  .editor {
    /* height: 100%; */
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
    /* height: 100%; */
    margin-bottom: 6px;
  }
  :global(ul[data-type="taskList"] div) {
    padding-left: 8px;
  }
  :global(ul[data-type="taskList"] li) {
    display: flex;
    align-items: start;
  }
  :global(ul[data-type="taskList"] li[data-checked="true"]) {
    text-decoration: line-through;
  }
  :global(ul[data-type="taskList"] li label) {
    background-color: red;
    display: contents;
  }

  :global(pre) {
    background-color: #303843;
    border-radius: 0.25rem;
    padding: 5px;
    color: #d2deee;
    margin: 5px;
    margin-right: 15px;
  }
  :global(input) {
    display: inline;
  }
  :global(.tiptap) {
    outline: none;
    /* height: 100%; */
    overflow: scroll;
    margin-left: 7px;
    margin-right: 8px;
    padding-left: 15px;
    padding-top: 3px;
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
